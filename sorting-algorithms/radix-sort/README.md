# Radix sort

## Overview

Radix sort assumes that each of the $$n$$ input elements is a sequence of length $$d$$ of elements from a totally ordered set.

Radix sort assumes that each of the $$n$$ input elements can be divided into $$d$$ digits.

```text
Start with list I of n items
Each item can be divided into d digits
for(i = 1 to d) {
  use a stable sort to sort I on digit i
}
```

{% embed url="https://en.wikipedia.org/wiki/Radix\_sort" caption="Radix sort - Wikipedia" %}

{% embed url="https://neerc.ifmo.ru/wiki/index.php?title=%D0%A6%D0%B8%D1%84%D1%80%D0%BE%D0%B2%D0%B0%D1%8F\_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0" caption="Radix sort - Ifmo" %}

## Complexity

* $$n$$ - number of elements.
* $$d$$ - number of digits in each element.
* $$S(n)$$ - space complexity of stable sort.
* $$T(n)$$ - time complexity of stable sort.

| Space | Time | Stability |
| :--- | :--- | :--- |
| $$O(S(n))$$ | $$O(d*T(n))$$ | Stable |

