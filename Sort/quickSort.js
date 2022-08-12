function partition(arr, start, end) {
    var pivotValue = arr[start];
    var swapIndex = start;
    for (var i = start + 1; i <= end; i++) {
        if (arr[i] <= pivotValue) {
            swapIndex++;
            if (i !== swapIndex) {
                var temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
            }
        }
    }
    if (swapIndex !== start) {
        var temp = arr[start];
        arr[start] = arr[swapIndex];
        arr[swapIndex] = temp;
    }
    return swapIndex;
}
function quickSort(arr, start = 0, end = arr.length -1) {
    if (start >= end) return;
    var pivotIndex = partition(arr, start, end);
    // Left
    quickSort(arr, start, pivotIndex - 1);
    // Right
    quickSort(arr, pivotIndex + 1, end);
    return arr;
}
console.log(quickSort([1,3,7,2,9,6]))