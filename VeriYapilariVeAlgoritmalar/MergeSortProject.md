# Merge Sort

```
[16,21,11,8,12,22]
```

#### Soru 1) Yukarıdaki dizinin sort türüne göre aşamalarını yazınız.

```
[16,21,11,8,12,22]
[16,21,11]  [8,12,22]	Aşama 1
                                     
[16]   [21,11]  [8]		[12,22]		Aşama 2
                               
[16] 	[21]     [11]   [8]	    [12]	  [22]		Aşama 3
                          
[16]  	[11,21]		[8]		[12,22]			Aşama 4
                          	   
[11,16,21]		 [8,12,22]		Aşama 5								
[8,11,12,16,21,22]		Aşama 6
```

#### Soru 2) Big-O gösterimini yapınız.

```
Her aşamada O(n) gelir.
n = 2^x
logn = x
O(n logn)
```