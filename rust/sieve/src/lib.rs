pub fn primes_up_to(upto: i32) -> Vec<i32> {
    if upto <= 1 { return vec![]; }
    let upper_limit = upto + 1;
    let mut bools: Vec<bool> = (2..upper_limit).map(|_| true).collect();
    for i in 2..upper_limit {
      if bools[(i-2) as usize] {
        for j in (i*i)..upper_limit {
          if j % i == 0 {
            bools[(j-2) as usize] = false
          }
        }
      }
    }

    bools.iter()
        .enumerate()
        .filter(|&(_, &value)| value)
        .map(|(index, _)| (index + 2) as i32)
        .collect()
}
