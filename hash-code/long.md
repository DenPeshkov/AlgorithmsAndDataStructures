# Long

Because we need 32-it `int` hash code return `xor` of most significant 32-bits with least significant 32-bits

```java
public int hashCode() {
  return (int)(value ^ (value >>> 32));
}
```

