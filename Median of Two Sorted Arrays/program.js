
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
  var target = [];
  var i = 0, j = 0, len1 = nums1.length, len2 = nums2.length;
  var len = len1 + len2;
  var medianIndex = 0, k = 0;

  while( i < len1 && j < len2) {
    if (nums1[i] > nums2[j]) {
      target[k++] = nums2[j++];
    } else {
      target[k++] = nums1[i++];
    }
  }


  while(i < len1) {
    target[k++] = nums1[i++];
  }

  while(j < len2) {
    target[k++] = nums2[j++];
  }


  if (len % 2 == 0) {
    return ((target[len / 2]  + target[(len/2) - 1]) / 2);
  } else {
    return target[parseInt(len/2)];
  }
};

var num1 = process.argv[2] ? process.argv[2].split(',') : [];
var num2 = process.argv[3] ? process.argv[3].split(',') : [];


num1 = num1.map(function(e) { return parseInt(e); });
num2 = num2.map(function(e) { return parseInt(e); });


console.log(findMedianSortedArrays(num1, num2));

