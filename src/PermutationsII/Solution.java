package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liutaotao on 2017/12/4.
 */
public class Solution {
    /**
     #include <iostream>
     #include <algorithm>
     #include <vector>
     using namespace std;

     class Solution
     {
     public:
     void recursion(vector<int> num, int start, vector<vector<int>> &res)
     {
     if (start == num.size() - 1)
     {
     res.push_back(num);
     return;
     }
     for (int i = start; i < num.size(); i++)
     {
     cout << "start = " << start << ", i = " << i << endl;
     if (start != i && num[start] == num[i])
     continue;
     swap(num[start], num[i]);
     recursion(num, start + 1, res);
     }
     }
     vector<vector<int>> permuteUnique(vector<int> &num)
     {
     sort(num.begin(), num.end());
     vector<vector<int>> res;
     recursion(num, 0, res);
     return res;
     }
     };
     void printVector(vector<int> &pt)
     {
     cout << "{ ";
     for (int j = 0; j < pt.size(); j++)
     {
     cout << pt[j] << " ";
     }
     cout << "} " << endl;
     }
     int main()
     {

     vector<int> v;
     v.push_back(1);
     v.push_back(2);
     v.push_back(1);

     Solution *s = new Solution();
     vector<vector<int>> res = s->permuteUnique(v);
     for (int i = 0; i < res.size(); i++)
     {
     printVector(res[i]);
     }
     }

     */
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    private void perm(int[] num, int start, List<List<Integer>> res) {
        if (start == num.length - 1) {
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < num.length; i++) {
            System.out.println("start = " + start + ", i = " + i);
            if (start != i && num[start] == num[i]) continue;
            swap(num, i, start);
            perm(num, start + 1, res);
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        perm(num, 0, res);
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 1};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(num);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
