"""consitent hash
"""

import hashlib
from bisect import insort, bisect, bisect_left


def hash(string, encoding='utf-8'):
    return int(hashlib.md5(string.encode(encoding)).hexdigest(), 16) >> 100


class ConsistentHash():

    def __init__(self, nodes, replicas=3):
        self.nodes = {}
        self.ring = []
        for node in nodes:
            self.add(node)

    def add(self, node):
        key = hash(node)
        if key in self.nodes:
            return
        insort(self.ring, key)
        self.nodes[key] = node
        print('[add] new node {0}@{1} to ring'.format(node, key))

    def remove(self, node):
        key = hash(node)
        i = bisect_left(self.ring, key)
        if self.ring[i] == key:
            self.ring.remove(key)
            self.nodes.pop(key, None)
            print('[remove] node {0}@{1} from ring'.format(node, key))

    def request(self, req):
        key = hash(req)
        pos = bisect(self.ring, key) % len(self.ring)
        node = self.nodes[self.ring[pos]]
        print('[request] hit {0}@{1} - {2} in ring'.format(node, self.ring[pos], key))

    def __len__(self):
        return len(self.ring)

