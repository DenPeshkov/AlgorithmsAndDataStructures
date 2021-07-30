# Hash Table

{% hint style="info" %}
**Hash code**. An `int` between $$-2^{31}$$ and $$2^{31}-1$$ 

**Hash function**. An `int` between $$0$$ and $$M-1$$ \(for use as array index\)
{% endhint %}

```java
class HashMap<K, V> {
  private int N; // number of key-value pairs
  private int M; // hash table size
  private SingleLinkedList<K, V>[] st; // array of ST objects
  
  public SeparateChainingHashST() {
    this(997);
  }
  
  public SeparateChainingHashST(int M) { // Create M linked lists.
    this.M = M;
    st = (SingleLinkedList<K, V>[]) new SinleLinkedList[M];
    for (int i = 0; i < M; i++) st[i] = new SingleLinkedList();
  }
  
  // get positive integer
  // cannot use Math.abs() because it can produce negative value
  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }
  
  public Value get(Key key) {
    return (Value) st[hash(key)].get(key);
  }
  
  public void put(Key key, Value val) {
    st[hash(key)].put(key, val);
  }
  
  public void delete(Key key) {
    st[hash(key)].delete(key);
  }
}
```

| Space |
| :--- |
| $$\Theta(n)$$  |

| Procedure | Time |
| :--- | :--- |
| get | $$\Omega(1)\ \Theta(1)\ O(n)$$  |
| put | $$\Omega(1)\ \Theta(1)\ O(n)\ amortised$$  |
| delete | $$\Omega(1)\ \Theta(1)\ O(n)$$  |

