---
title: Floyd-Warshall
date: 2023-12-20 21:55:43 +09:00
categories: [자료구조 이론, 자료구조 이론]
tags:
  [
    Floyd-Warshall ,
    
    .
    .
    .
  ]
---


<p>그래프에서 정점끼리의 최단 경로를 구하는 방법은 여러가지가 있습니다. 플로이드 와샬 알고리즘에 대해서 알아보기 전에 이에 대해서 간단히 살펴보도록 하겠습니다.</p>

<ul>
<li>
<p>하나의 정점에서 다른 하나의 정점까지의 최단 경로를 구하는 문제</p>
</li>
<li>
<p>하나의 정점에서 다른 모든 정점까지의 최단 경로를 구하는 문제</p>
</li>
<li>
<p>하나의 목적지로가는 모든 최단 경로를 구하는 문제</p>
</li>
<li>
<p>모든 최단 경로를 구하는 문제</p>
</li>
</ul>

## 플로이드워셜 이란?
___
다익스트라는 하나의 정점에서 다른 모든 정점까지의 최단 거리를 구하는 알고리즘(S.S.S.P - Single Source Shortest Path) 이었다면, 플로이드-워셜 알고리즘은 한 번 실행하여 모든 노드 간 최단 경로를 구할 수 있습니다.


## 과정
___
<p>모든 노드 간의 최단거리를 구해야 하므로 2차원 인접 행렬을 구성합니다. 알고리즘은 여러 라운드로 구성됩니다. 라운드마다 각 경로에서 새로운 중간 노드로 사용할 수 있는 노드를 선택하고, 더 짧은 길이를 선택하여 줄이는 과정을 반복합니다.
</p>

<img src="/assets/img/favicons/floyd1.png" alt="" width="350" height="370">

<p>초기 그래프를 인접행렬로 나타내면 다음과 같습니다. INF는 해당 노드에서 특정 노드까지 가는 길이 없다는 뜻입니다.</p>
<table><thead><tr><th style="text-align: center">0</th><th style="text-align: center">5</th><th style="text-align: center">INF</th><th style="text-align: center">9</th><th style="text-align: center">1</th></tr></thead><tbody><tr><td style="text-align: center"><strong>5</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>INF</strong></td></tr><tr><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>INF</strong></td></tr><tr><td style="text-align: center"><strong>9</strong></td><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td></tr><tr><td style="text-align: center"><strong>1</strong></td><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td></tr></tbody></table>

<p>이 그래프는 1번부터 5번 노드까지 존재하므로 알고리즘은 총 5라운드의 과정을 거칩니다. 즉, 모든 노드들을 중간 노드로 선정하는 과정을 각 라운드마다 거칩니다. 예를 들어 2라운드는 2번 노드가 중간 노드이며, 3라운드는 3번 노드가 중간 노드가 될 것입니다.

2번에서 4번으로 가는 길은 원래 없었으나, 1번 노드를 중간 노드로 선정할 경우 2-1-4(길이 5+9=14) 로 갈 수 있게 됩니다. (업데이트된 길이는 📍로 표시)
</p>

<table><thead><tr><th style="text-align: center"><strong>0</strong></th><th style="text-align: center"><strong>5</strong></th><th style="text-align: center"><strong>INF</strong></th><th style="text-align: center"><strong>9</strong></th><th style="text-align: center"><strong>1</strong></th></tr></thead><tbody><tr><td style="text-align: center"><strong>5</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>14📍</strong></td><td style="text-align: center"><strong>6📍</strong></td></tr><tr><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>INF</strong></td></tr><tr><td style="text-align: center"><strong>9</strong></td><td style="text-align: center"><strong>14📍</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td></tr><tr><td style="text-align: center"><strong>1</strong></td><td style="text-align: center"><strong>6</strong>📍</td><td style="text-align: center"><strong>INF</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td></tr></tbody></table>

<p>1번-3번 노드를 잇는 경로, 3번-5번 노드를 잇는 경로가 새로 생기게 됩니다.</p>
<table><thead><tr><th style="text-align: center"><strong>0</strong></th><th style="text-align: center"><strong>5</strong></th><th style="text-align: center"><strong>7📍</strong></th><th style="text-align: center"><strong>9</strong></th><th style="text-align: center"><strong>1</strong></th></tr></thead><tbody><tr><td style="text-align: center"><strong>5</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>14</strong></td><td style="text-align: center"><strong>6</strong></td></tr><tr><td style="text-align: center"><strong>7📍</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>8📍</strong></td></tr><tr><td style="text-align: center"><strong>9</strong></td><td style="text-align: center"><strong>14</strong></td><td style="text-align: center"><strong>7</strong></td><td style="text-align: center"><strong>0</strong></td><td style="text-align: center"><strong>2</strong></td></tr><tr><td style="text-align: center"><strong>1</strong></td><td style="text-align: center"><strong>6</strong></td><td style="text-align: center"><strong>8📍</strong></td><td style="text-align: center"><strong>2</strong></td><td style="text-align: center"><strong>0</strong></td></tr></tbody></table>
<p>이런 과정으로 5번 노드를 중간 노드로 선정하는 라운드까지 모두 거치면 행렬에는 모든 노드 간 최단 거리가 들어가게 됩니다.</p>

## 소스코드

```java
import com.sun.org.apache.bcel.internal.util.Args;

public class main {
  public static Main(String[] args) {
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
  }
}
```
