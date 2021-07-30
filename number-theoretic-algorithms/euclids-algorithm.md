---
description: >-
  Алгоритм для нахождения наибольшего общего делителя GCD двух целых
  неотрицательных чисел.
---

# Euclid's algorithm \(НОД/GCD\)

{% tabs %}
{% tab title="recursion" %}
```java
int gcd(int a, int b) {
  if (b == 0) return a;
  int r = a % b;       
  return gcd(b, r);    
}            
```
{% endtab %}

{% tab title="loop" %}
```java
int gcd(int a, int b) {
  while (b != 0) {     
    int r = a % b;     
    a = b;             
    b = r;             
  }                    
  return a;            
}
```
{% endtab %}
{% endtabs %}

| Space | Time |
| :--- | :--- |
| $$O(1)$$  | $$O(log\ min(a,b))$$  |

{% hint style="info" %}
Если $$a < b$$ то $$a \% b=a$$ и на втором шаге на вход поступят $$b, a$$  
{% endhint %}

{% hint style="info" %}
Алгоритм может применяться для любого количества чисел: $$gcd(a, b, c) = gcd(a, gcd(b, c)) = gcd(gcd(a, b), c) = gcd(gcd(a, c), b).$$
{% endhint %}



