### BinarySearch 说明

### 引用
- [LeetCode Binary Search Summary 二分搜索法小结](http://www.cnblogs.com/grandyang/p/6854825.html)
- [WikiPedia BinarySearch](https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95#Java_while_%E5%BE%AA%E7%8E%AF)


### Code

```

// while 循环
public int binarySearch(int[] nums, int left, int right, int target) {
    
    while(left <= right) {
        int mid = left + (right -left)/2;
        if (nums[mid] < target) left = mid + 1;
        else if (nums[mid] > target) right = mid - 1;
        else return mid;
    }
    return -1;
}

```

```

// 递归

public int binarySearch(int[] nums, int left, int right, int target) {

    if (left > right) return -1;
    
    int mid = left + (right -left)/2;
    if (nums[mid] < target) return binarySearch(nums, mid + 1, right, target);
    else if (nums[mid] > target) return binarySearch(nums, left,  mid - 1, target);
        else return mid;
    
}
```