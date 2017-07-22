extern crate regex;
use regex::Regex;

pub fn is_valid(input: &str) -> bool {
    let valid = Regex::new(r"^[\d\s]{2,}$").unwrap();
    if !valid.is_match(input) {
        return false;
    }
    let replace = Regex::new(r"\s+").unwrap();
    let replaced = replace.replace_all(input, "");
    if replaced.len() <= 1 {
        return false;
    }
    let reversed: String = replaced.chars().rev().collect();
    let sum = reversed
        .char_indices()
        .fold(0, |acc, (idx, char)|{
            if idx % 2 != 0 {
                let mut num = char.to_digit(10).unwrap() * 2;
                if num > 9 {num = num - 9}
                return acc + num
            }
            acc + char.to_digit(10).unwrap()
        });
    sum % 10 == 0
}