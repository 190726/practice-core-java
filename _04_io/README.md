#Path를 이용한 디렉토리 생성

전통적인 디렉토리 생성방법은 아래와 같다. 

```java
File oldDir = new File("e:/temp/subtemp");
boolean resultMkdir = oldDir.mkdir();
```

Path, Files를 이용해 아래와 같이 생성할수 있다. 

```java
Path newDir = Paths.get("e:/temp/subtemp");
if(Files.notExists(newDir)) {
  try {
    Path createDirectories = Files.createDirectories(newDir);
    System.out.println(createDirectories.toRealPath());
  } catch (IOException e) {
    e.printStackTrace();
  }
}
```

후자의 방법의 장점은, 
  1. Nested Directory 생성이 가능한점
  2. 생성오류에 대한 비교적 명확한 exception 이 발생한다는점
