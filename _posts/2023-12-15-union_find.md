---
title: union-find
date: 2023-12-15 20:25:43 +09:00
categories: [자료구조 이론, union-find]
tags:
  [
    union-find,
    
    .
    .
    .
  ]
---


<div class="sc-fXEqDS jlUmJL atom-one"><h2 id="-목차">✔ 목차</h2>
<ol>
<li>유니온 파인드란?</li>
<li>유니온 파인드 예시</li>
<li>유니온 파인드 구현 - Java</li>
</ol>
<br>


## 🔎 유니온 파인드란?

<p><strong>유니온 파인드(Union-Find) 알고리즘</strong></p>
<ul>
<li>그래프/트리의 대표적 알고리즘</li>
<li>서로소인 부분집합의 표현</li>
<li>여러 노드가 있을 때, 두 노드가 같은 그래프에 속해있는지 알 수 있음</li>
<li><code>union(x, y)</code> 연산과 <code>find(x)</code> 연산으로 이루어져 있음<ul>
<li><code>union(x, y)</code> : x와 y그래프를 합친다.</li>
<li><code>find(x)</code> : x가 어느 그래프에 속하는지 연산한다.<br>
<br></li>
</ul></li>
</ul>


## 🔎 유니온 파인드 예시

<p>노드 1부터 5까지 있는 그래프가 있다.<br>
<img src="/assets/img/favicons/union1.png"></p>
<p>위의 그림에서 노드 5개는 서로 연결되지 않고있다. 이 때 부모는 자기 자신을 가르키도록 한다. 이 단계를 보통 부모노드 초기화라고 부른다.<br>
<code>x</code>는 노드 번호이고, <code>parent[x]</code>는 <code>x</code>가 어떤 부모 노드에 속해있는지 알려준다.<br>
<br></p>
<p><strong>1)</strong> <code>union(1, 2)</code><br>
<img src="/assets/img/favicons/union2.png"></p>
<ul>
<li><code>parent[2] = 1</code><br>
노드 1과 2를 연결해준다. 이 때 노드 번호가 작은 쪽이 부모가 되도록 한다.<br>
<br></li>
</ul>
<p><strong>2)</strong> <code>union(3, 4)</code> , <code>union(3, 5)</code><br>
<img src="/assets/img/favicons/union3.png"></p>
<ul>
<li><code>parent[4] = 3</code> , <code>parent[5] = 3</code><br>
위와 동일한 방식으로 union을 해준다.</li>
</ul>
<p>노드 2와 4의 부모 노드는 find로 찾을 수 있다.<br>
<code>find(2)</code> = 1<br>
<code>find(4)</code> = 3<br>
<br></p>
<p><strong>3)</strong> <code>union(2, 4)</code><br>
<img src="/assets/img/favicons/union4.png"></p>
<ul>
<li><code>parent[3] = 1</code><br>
2가 속한 그래프와 3이 속한 그래프를 합친다. <code>find(2)</code> = 1이고, <code>find(4)</code> = 3이다. 노드 3은 노드 1보다 번호가 작으므로 노드 3의 부모노드는 1이 된다. </li>
</ul>
<p><code>find(x)</code>를 할 때 노드번호 <code>x</code>와<code>parent[x]</code>의 값이 같아야 하므로 노드 4의 find는 1이 된다.<br>
<code>find(4)</code> = 1<br>
<br></p>
<hr>
