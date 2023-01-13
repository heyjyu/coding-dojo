function test() {
  console.log(`cacheHit(["jeju"],"jeju"): true = ${cacheHit(['jeju'], 'jeju')}`);
  console.log(`cacheHit(["la"],"jeju"): false = ${cacheHit(['la'], 'jeju')}`);

  console.log(`nextCacheArray(3,[],"Jeju"): [jeju] = ${nextCacheArray(3, [], 'Jeju')}`);
  console.log(`nextCacheArray(3,[jeju],"Jeju"): [jeju] = ${nextCacheArray(3, ['jeju'], 'Jeju')}`);

  console.log(`totalRuntime(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]): 50 = ${totalRuntime(3, ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA'])}`);
  console.log(`totalRuntime(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]): 21 = ${totalRuntime(3, ['Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul'])}`);
}

function solution(cacheSize, cities) {
  // test();
  const answer = totalRuntime(cacheSize, cities);
  return answer;
}

function cacheHit(cacheArray, city) {
  return cacheArray.indexOf(city.toLowerCase()) >= 0;
}

function nextCacheArray(cacheSize, cacheArray, city) {
  const nextArray = [...cacheArray];
  const lowerCasedCity = city.toLowerCase();

  if (cacheArray[cacheArray.length - 1] === lowerCasedCity) {
    return nextArray;
  }

  if (cacheHit(cacheArray, city)) {
    return [...nextArray.filter((cache) => cache !== lowerCasedCity), lowerCasedCity];
  }

  if (cacheArray.length < cacheSize) {
    return [...cacheArray, lowerCasedCity];
  }

  nextArray.shift();
  nextArray.push(lowerCasedCity);

  return nextArray;
}

function totalRuntime(cacheSize, cities) {
  let runtime = 0;
  let cacheArray = [];

  if (cacheSize === 0) {
    return cities.length * 5;
  }

  for (let i = 0; i < cities.length; i += 1) {
    if (cacheHit(cacheArray, cities[i])) {
      runtime += 1;
    }

    if (!cacheHit(cacheArray, cities[i])) {
      runtime += 5;
    }

    cacheArray = nextCacheArray(cacheSize, cacheArray, cities[i]);
  }

  return runtime;
}
