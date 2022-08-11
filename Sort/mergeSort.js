function mergeSort(unsortArray) {
    if (unsortArray.length <=1) {
        return unsortArray;
    }
    var middle = Math.floor(unsortArray.length/2);
    var left = unsortArray.slice(0,middle);
    var right = unsortArray.slice(middle);
    //divide
    return merge(mergeSort(left), mergeSort(right));
    
}
function merge (left, right) {
    //merge
    var arr = [];
    while(left.length && right.length) {
        if(left[0] < right[0]) {
            arr.push(left.shift());
        } else {
            arr.push(right.shift());
        }
    }
    while(left.length) {
        arr.push(left.shift());
    }
    while(right.length) {
        arr.push(right.shift());
    }
    return arr;
}
var sortArray = [1,9,4,3,5,24,6,6,87];
console.log(mergeSort(sortArray));
