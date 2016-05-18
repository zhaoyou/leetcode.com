
var binarySearch = function(arr, target) {

}

var find = function(arr, target, start, end) {


  if (start >= end) { return;}

  var middle = Math.floor((end - start + 1)  / 2);
  var start1 = start, end1 = middle;
  var start2 = middle + 1, end2 = end;

  console.log(start1, end1, middle, start2, end2);

  find(arr, target, start1, end1);
  find(arr, target, start2, end2);

  var k = start;

  while(start1 <= end1 && start2 <= end2) {
    target[k++] = arr[start1] > arr[start2] ? arr[start2++] : arr[start1++];
  }

  while(start1 <= end1) {
    target[k++] = arr[start1++];
  }

  while(start2 <= end2) {
    target[k++] = arr[start2++];
  }


  for(k = start; k <= end; k++) {
    arr[k] = target[k];
  }

}

var main_merge_sort = function(p) {
  var arr = p.split(',');
  console.log(arr);
  var len = arr.length;
  var target = new Array(len);
  find(arr, target, 0, len - 1);
  console.log(arr);
}


main_merge_sort(process.argv[2]);
