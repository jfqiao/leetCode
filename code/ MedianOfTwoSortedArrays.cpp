/* Problem description.
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/
//solution
class Solution {
public:
    double findMedianSortedArrays(vector<int>& A, vector<int>& B) 
    {
        int m = A.size(), n = B.size();
         if ((m + n) & 1) 
         {
            return findKth((m + n - 1) / 2, A, 0, m - 1, B, 0, n - 1);
         } 
        else 
        {
            int x = findKth((m + n) / 2 - 1, A, 0, m - 1, B, 0, n - 1);
            int y = findKth((m + n) / 2, A, 0, m - 1, B, 0, n - 1);
            return (x + y) / 2.0;
        }
    }
    int findKth(int k, vector<int>& A, int l1, int r1, vector<int>& B, int l2, int r2) 
    {
        int m1, m2;
        while(l1 <= r1 && l2 <= r2)
        {
            m1 = (l1 + r1) / 2;
            m2 = (l2 + r2) / 2;
        if (A[m1] > B[m2]) 
        {
            if (k + 1 < m1 - l1 + 1 + m2 - l2 + 1) 
            {
                r1 = m1 -1;
               // return findKth(k, A, l1, m1 - 1, B, l2, r2);
            } 
            else 
            {
                //return findKth(k - (m2 - l2 + 1), A, l1, r1, B, m2 + 1, r2);
                k -= (m2 - l2 + 1);
                l2 = m2 + 1;
            }
        } 
        else 
        {
            if (k + 1 < m1 - l1 + 1 + m2 - l2 + 1) 
            {
                //return findKth(k, A, l1, r1, B, l2, m2 - 1);
                r2 = m2 - 1;
            } 
            else 
            {
                // return findKth(k - (m1 - l1 + 1), A, m1 + 1, r1, B, l2, r2);
                k -= (m1 - l1 +1);
                l1 = m1 + 1;
            }
        }
        }
        if (l1 > r1) 
        {
            return B[l2 + k];
        }
        else
        {
            return A[l1 + k];
        }
    }
};
