---
description: Integer's hash code
---

# Integer

{% hint style="info" %}
The most commonly used method for hashing integers is called _modular hashing_ : we choose the array size $$M$$ to be prime and, for any positive integer key $$k$$ , compute the remainder when dividing $$k$$ by $$M$$ .

If $$M$$ is not prime, it may be the case that not all of the bits of the key play a role, which amounts to missing an opportunity to disperse the values evenly.
{% endhint %}

Integer's hash code is just it's value \(32-bit integer\)

```java
public int hashCode() {
  return value; //Integer's value
}
```

