# Binary search

Стандартный двоичный поиск. Если в массиве есть повторяющиеся элементы будет выбран случайный элемент.

{% tabs %}
{% tab title="loop" %}
```java
<T extends Comparable<T>> int binarySearch(T[] arr, T val) {
  int l = 0;
  int r = arr.length - 1;
  while (l <= r) {
    int m = (l + r) >>> 1; // to avoid overflow
    if (arr[m].compareTo(val) < 0) l = m + 1;
    else if (arr[m].compareTo(val) > 0) r = m - 1;
    else return m;
  }
  return -1;
}
```
{% endtab %}

{% tab title="recursion" %}
```java
<T extends Comparable<T>> int binarySearch(T[] arr, T val) {
  return binarySearch(arr,val,0,arr.length-1);
}

<T extends Comparable<T>> int binarySearch(T[] arr, T val, int l, int r) {
  if (l <= r) {
    int m = (l + r) >>> 1; // to avoid overflow
    if (arr[m].compareTo(val) < 0) return binarySearch(arr,val,m+1,r);
    else if (arr[m].compareTo(val) > 0) return binarySearch(arr,val,l,m-1);
    else return m;
  }
  return -1;
}
```
{% endtab %}
{% endtabs %}

| Space | Time |
| :--- | :--- |
| $$O(1)$$  | $$\Theta(log\ n)\ O(log\ n)$$  |



