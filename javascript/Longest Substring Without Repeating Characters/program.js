/**
   * @param {string} s
    * @return {number}
     */
var lengthOfLongestSubstring = function(s) {

  //if (!s || !s.length) {return 0;}
  //var len = s.length;
  //var target = 1, i = 0, j = 0, index = 1 ;
  //var str = {};

  //for (; i < len; i++) {
  //  if (target >= len -i) { return target;}

  //  str = {};

  //  j = index;

  //  for(var k = i; k < index; k++) {
  //    str[s[k]] = s[k];
  //  }


  //  for (; j < len; j++) {
  //    if (str[s[j]]) {
  //      index = j ;
  //      break;
  //    }
  //    str[s[j]] = s[j];
  //  }

  //  if (j - i > target) { target = j - i;}
  //}
  //return target;
};

var lengthOfLongestSubstring2 = function(s) {
  var len = s.length;
  var i = 0, j = 0, target = 0;
  var str = '';

  while (i < len) {

    while( str.indexOf(s[j]) == -1  && j < len) {
      str += s[j];
      j++;
    }
    if (j < len) {
      var first_index = str.indexOf(s[j]);

      if (str.length > target) {target = str.length;console.log('str: %s length is  %d', str, str.length);}
      str = str.substr(first_index + 1);
      i++;
      continue;
    } else {
      if (str.length > target) { target = str.length;}
      break;
    }

  }
  return target;
}
console.log('%s: %d', process.argv[2], lengthOfLongestSubstring2(process.argv[2]))
//console.log('%s: %d', process.argv[2], lengthOfLongestSubstring(process.argv[2]));
