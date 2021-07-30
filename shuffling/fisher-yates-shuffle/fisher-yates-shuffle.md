# Fisher-Yates shuffle

## Implementation

```java
public class FisherYatesShuffle {

  static <T> void shuffle(T[] arr) {
    int N = arr.length;

    for (int i = 0; i < N; i++) {
      int r = ThreadLocalRandom.current().nextInt(i + 1);
      exchange(arr, i, r);
    }
  }

  private static <T> void exchange(T[] arr, int i, int j) {
    T t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
```

## Complexity

| Space | Time |
| :--- | :--- |
| $$O(1),\ O(1)$$  | $$O(n),\ O(n),\ O(n)$$  |

## Notes

Can be used when the array to be shuffled is generated dynamically.



