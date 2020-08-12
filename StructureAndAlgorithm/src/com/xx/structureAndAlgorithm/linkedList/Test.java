package com.xx.structureAndAlgorithm.linkedList;

/**
 * @author xiaoxinga
 * @date 2020/07/23 9:38
 * @since
 */
public class Test {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    public int[] sortArray(int[] nums) {
        mergerSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int prv = start + 1;
        int left = start;
        while (left <= end) {
            if (nums[prv] <= nums[start]) {
                swap(nums, left + 1, prv);
                left++;
            }
            prv++;
        }
        swap(nums, left, start);
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void mergerSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        // 先对左右子数组进行排序
        mergerSort(nums, start, mid);
        mergerSort(nums, mid + 1, end);
        // 临时数组存放合并结果
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int cur = 0;
        // 开始合并数组
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) temp[cur] = nums[i++];
            else temp[cur] = nums[j++];
            cur++;
        }
        while (i <= mid) temp[cur++] = nums[i++];
        while (j <= end) temp[cur++] = nums[j++];
        // 合并数组完成，拷贝到原来的数组中
        for (int k = 0; k < temp.length; k++) {
            nums[start + k] = temp[k];
        }
    }
}
