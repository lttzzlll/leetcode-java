""" Consistent Hash With Replicas
"""
import hashlib


def hash(string, encoding='utf-8'):
    return int(hashlib.md5(string.encode(encoding)).hexdigest(), 16) >> 110

def bsearch(array, value):
    size = len(array)
    low, high = 0, size - 1
    while low <= high:
        mid = (low + high) >> 1
        if value > array[mid][0]:
            low = mid + 1
        elif value < array[mid][0]:
            high = mid - 1
        else:
            return mid
    return -1


def bisect_right(array, value):
    size = len(array)
    low, high = 0, size - 1
    while low <= high:
        mid = (low + high) >> 1
        if value >= array[mid][0]:
            low = mid + 1
        else:
            high = mid - 1
    return low


class ConsistentHash():
    def __init__(self, nodes, replicas=3):
        self.replicas = replicas
        self.nodes = set()
        self.ring = []
        for node in nodes:
            self.add(node)

    def add(self, node):
        if node in self.nodes:
            return
        self.nodes.add(node)
        print('[Nodes] new node {}'.format(node))
        for i in range(0, self.replicas):
            nodename = f'{node}:{i}'
            key = hash(nodename)
            pos = bisect_right(self.ring, key)
            self.ring.insert(pos, (key, node))
            print('[Ring] new bucket: <{}:{}>@{}'.format(nodename, key, pos))

    def remove(self, node):
        if node not in self.nodes:
            return
        self.nodes.remove(node)
        print('[Node] remove node: {}'.format(node))
        for i in range(0, self.replicas):
            nodename = f'{node}:{i}'
            key = hash(nodename)
            pos = bsearch(self.ring, key)
            self.ring.pop(pos)
            print('[Ring] remove bucket: <{}:{}>@{}'.format(nodename, key, pos))

    def request(self, req):
        key = hash(req)
        pos = bisect_right(self.ring, key) % len(self.ring)
        print('[Request] hit {}@{}:{}-{}'.format(key, self.ring[pos][0], self.ring[pos][-1], pos))
        return self.ring[pos]

    def __len__(self):
        return len(self.ring)

if __name__ == '__main__':
    ch = ConsistentHash(['A', 'H', 'O', 'R', 'U', 'S'])
    for i in range(3):
        ch.request(str(i))

    ch.add('F')
    for i in range(3):
        ch.request(str(i))

    ch.add('J')
    for i in range(3):
        ch.request(str(i))

    ch.add('M')
    for i in range(3):
        ch.request(str(i))

    ch.remove('A')
    for i in range(3):
        ch.request(str(i))

    ch.remove('H')
    for i in range(3):
        ch.request(str(i))

    ch.remove('U')
    for i in range(3):
        ch.request(str(i))

