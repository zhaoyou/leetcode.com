/**
   * @param {string} s
    * @return {number}
     */
var lengthOfLongestSubstring = function(s) {

if (!s || !s.length) {return 0;}
  var len = s.length;
  var target = 1, i = 0; j = 0;
  var str = {};

  for (; i < len; i++) {
    if (target >= len -i) { return target;}

    str = {};
    str[s[i]] = s[i];

    //console.log('str: ', str);

    for (j = i + 1; j < len; j++) {
      if (str[s[j]]) { break;}
      str[s[j]] = s[j];
    }

    //console.log("i: %d, j: %d", i, j);

    if (j - i > target) { target = j - i;}
  }
  return target;
  //if (!s || !s.length) {return 0;}
  //var len = s.length;
  //var target = 1, i = 0, j = 0, index = 1 ;
  //var str = {};

  //for (; i < len; i++) {
  //  if (target >= len -i) { return target;}

  //  str = {};
  //  str[s[i]] = s[i];

  //  j = index;


  //  for (; j < len; j++) {
  //    if (str[s[j]]) {
  //      for(var k = i; k < j; k++) {
  //        str[s[k]] = s[k];
  //      }
  //      index = j ;
  //      console.log('break j: ', j);
  //      break;
  //    }
  //    str[s[j]] = s[j];
  //    console.log('loop str', str, j);
  //  }

  //  console.log('str:', str);
  //  console.log("i: %d, j: %d", i, j);
  //  console.log('---------');

  //  if (j - i > target) { target = j - i;}
  //}
  //return target;
};

console.log('%s: %d', process.argv[2], lengthOfLongestSubstring(process.argv[2]));
