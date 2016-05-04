/**
   * @param {string} s
    * @return {number}
     */
var lengthOfLongestSubstring = function(s) {

  if (!s || !s.length) {return 0;}
  var len = s.length;
  var target = 1, i = 0, j = 0, index = 1 ;
  var str = {};

  for (; i < len; i++) {
    if (target >= len -i) { return target;}

    str = {};

    j = index;

    for(var k = i; k < index; k++) {
      str[s[k]] = s[k];
    }


    for (; j < len; j++) {
      if (str[s[j]]) {
        index = j ;
        break;
      }
      str[s[j]] = s[j];
    }

    if (j - i > target) { target = j - i;}
  }
  return target;
};

console.log('%s: %d', process.argv[2], lengthOfLongestSubstring(process.argv[2]));
