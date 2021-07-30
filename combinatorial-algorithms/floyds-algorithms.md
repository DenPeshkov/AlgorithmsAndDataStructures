---
description: Cycle detection Floyd's Tortoise and Hare algorithm
---

# Floyd's algorithms

For any function $$f $$ that maps a finite set $$S$$ to itself, and any initial value $$x_{i}$$ in $$S$$ , the sequence of iterated function values $$x_{0},\ x_{1}=f(x_{0}),\ x_{2}=f(x_{1}),\ ...,\ x_{i}=f(x_{i-1}),\ ...$$ must eventually use the same value twice: there must be some pair of distinct indices $$i$$ and $$j$$ such that $$x_{i}=x_{j}$$ . Once this happens, the sequence must continue periodically, by repeating the same sequence of values from $$x_{i}$$ to $$x_{j-1}$$ . **Cycle detection is the problem of finding** $$i$$ **and** $$j$$ **, given** $$f$$ **and** $$x_{0}$$ **.**

**In phase 1**, `hare = nums[nums[hare]]` is twice as fast as `tortoise = nums[tortoise]`. Since the hare goes fast, it would be the first one who enters the cycle and starts to run around the cycle. At some point, the tortoise enters the cycle as well, and since it's moving slower the hare catches the tortoise up at some _intersection_ point.

The hare has traversed twice as many nodes as the tortoise, _i.e._ $$2d(tortoise)=d(hare)$$ , that means

$$2(F + a) = F + nC + a$$ , where $$n$$ is some integer.

> Hence the coordinate of the intersection point is $$F+a=nC$$ .

**In phase 2**, we give the tortoise a second chance by slowing down the hare, so that it now moves with the speed of tortoise: `tortoise = nums[tortoise]`, `hare = nums[hare]`. The tortoise is back at the starting position, and the hare starts from the intersection point.

Let's show that this time they meet at the cycle entrance after $$F$$ steps.

* The tortoise started from zero, so its position after $$F$$ steps is $$F$$ ****.
* The hare started at the intersection point $$F+a=nC$$ , so its position after $$F$$ steps is $$nC+F$$ , that is the same point as $$F$$ .
* So the tortoise and the \(slowed down\) hare will meet at the entrance of the cycle.

```python
def floyd(f, x0):
    # Main phase of algorithm: finding a repetition x_i = x_2i.
    # The hare moves twice as quickly as the tortoise and
    # the distance between them increases by 1 at each step.
    # Eventually they will both be inside the cycle and then,
    # at some point, the distance between them will be
    # divisible by the period λ.
    tortoise = f(x0) # f(x0) is the element/node next to x0.
    hare = f(f(x0))
    while tortoise != hare:
        tortoise = f(tortoise)
        hare = f(f(hare))
  
    # At this point the tortoise position, ν, which is also equal
    # to the distance between hare and tortoise, is divisible by
    # the period λ. So hare moving in circle one step at a time, 
    # and tortoise (reset to x0) moving towards the circle, will 
    # intersect at the beginning of the circle. Because the 
    # distance between them is constant at 2ν, a multiple of λ,
    # they will agree as soon as the tortoise reaches index μ.

    # Find the position μ of first repetition.    
    mu = 0
    tortoise = x0
    while tortoise != hare:
        tortoise = f(tortoise)
        hare = f(hare)   # Hare and tortoise move at same speed
        mu += 1
 
    # Find the length of the shortest cycle starting from x_μ
    # The hare moves one step at a time while tortoise is still.
    # lam is incremented until λ is found.
    lam = 1
    hare = f(tortoise)
    while tortoise != hare:
        hare = f(hare)
        lam += 1
 
    return lam, mu
```

| Space | Time |
| :--- | :--- |
| $$\Theta(1)\ \Theta(1)\ \Theta(1)$$  | $$\Theta(n)\ \Theta(n)\ \Theta(n)$$  |

