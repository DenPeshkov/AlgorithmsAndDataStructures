# Double

{% hint style="info" %}
If the keys are real numbers between $$0$$ and $$1$$ , we might just multiply by $$M$$ and round off to the nearest integer to get an index between $$0$$ and $$M-1$$ . Although this approach is intuitive, it is defective because it gives more weight to the most significant bits of the keys; the least significant bits play no role. One way to address this situation is to use modular hashing on the binary representation of the key \(this is what Java does\).
{% endhint %}

Convert to `IEEE 754` 64-bits representation. And because we need 32-it `int` hash code return `xor` of most significant 32-bits with least significant 32-bits

```java
public int hashCode() {
  // convert to IEEE 64-bit representation
  long bits = doubleToLongBits(value);
  
  // xor most significant 32-bits with least significant 32-bits 
  return (int)(bits ^ (bits >>> 32));
}
```



