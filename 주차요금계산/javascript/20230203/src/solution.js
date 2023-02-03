function test() {
  console.log(`sortedCarNumbers(['05:34 5961 IN', '06:00 0000 IN', '06:34 0000 OUT', '07:59 5961 OUT', '07:59 0148 IN', '18:59 0000 IN', '19:09 0148 OUT', '22:59 5961 IN', '23:00 5961 OUT']): [0000,0148,5961] = ${sortedCarNumbers(['05:34 5961 IN', '06:00 0000 IN', '06:34 0000 OUT', '07:59 5961 OUT', '07:59 0148 IN', '18:59 0000 IN', '19:09 0148 OUT', '22:59 5961 IN', '23:00 5961 OUT'])}`);

  console.log(`timeInMinutes("05:34"): 334 = ${timeInMinutes('05:34')}`);

  console.log(`computeFee(334,[180, 5000, 10, 600]): 14600 = ${computeFee(334, [180, 5000, 10, 600])}`);

  console.log(`computeFees([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]): [14600, 34400, 5000] = ${computeFees([180, 5000, 10, 600], ['05:34 5961 IN', '06:00 0000 IN', '06:34 0000 OUT', '07:59 5961 OUT', '07:59 0148 IN', '18:59 0000 IN', '19:09 0148 OUT', '22:59 5961 IN', '23:00 5961 OUT'])}`);
}

function solution(fees, records) {
  // test();
  const answer = computeFees(fees, records);
  return answer;
}

function sortedCarNumbers(records) {
  const numbers = [...new Set(records.map((record) => record.split(' ')[1]))];

  numbers.sort();

  return numbers;
}

function timeInMinutes(time) {
  return time.split(':')[0] * 60 + Number(time.split(':')[1]);
}

function computeFee(duration, fees) {
  let fee = fees[1];

  const leftDuration = duration - fees[0];

  fee += leftDuration > 0 ? Math.ceil(leftDuration / fees[2]) * fees[3] : 0;
  
  return fee;
}

function computeFees(fees, records) {
  const durations = {};

  for (let i = 0; i < records.length; i += 1) {
    const [time, carNumber, type] = records[i].split(' ');

    const computedTime = type === 'IN' ? -timeInMinutes(time) : timeInMinutes(time);

    durations[carNumber] = durations[carNumber]
      ? durations[carNumber] + computedTime
      : computedTime;
  }

  return sortedCarNumbers(records)
    .map((number) => {
      const duration = durations[number] > 0 ? durations[number] : durations[number] + 23 * 60 + 59;

      return computeFee(duration, fees);
    });
}
