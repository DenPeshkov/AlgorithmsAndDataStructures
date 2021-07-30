# String

{% hint style="info" %}
Horner's method to hash string of length $$L$$ : $$L$$ multiples/adds

Equivalent to $$h=s[0]*31^{L-1}+...+s[L-3]*31^2+s[L-2]*31^1+s[L-1]*31^0$$ 
{% endhint %}

```java
public int hashCode(byte[] value) {
  int hash = 0;
  
  for (int i = 0; i < length(); i++)
    hash = s[i] + (31 * h) // s[i] i-th character of s
  
  return hash;
}
```

