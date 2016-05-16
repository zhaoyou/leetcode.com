
var binarySearch = function(arr, target) {

}

var find = function(arr, target) {

  var middle = arr.length / 2;

  if (middle == 0) return -1;

  if (arr[middle] < target) { return find(arr.slice(middle), target);}

  if (arr[middle] > target) { return find(arr.slice(0, middle), target);}

}
