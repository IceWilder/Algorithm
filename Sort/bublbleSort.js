function bubbleSort(arr) {
    var len = arr.length;
    var checked = true;
    do {
        var checked = false;
        for (var j = 0; j < len; j++) {
            if (arr[j] > arr[j + 1]) {
                var temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                checked = true;
            }
        }
    } while (checked);
    return arr;
}
console.log(bubbleSort([5,4,6,1,2]));