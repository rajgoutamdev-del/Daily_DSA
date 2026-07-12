# Two Sum

## Problem
Given an array of integers and a target value, find the indices of the two numbers that add up to the target.

## Approach
Used HashMap (Python dictionary) to store numbers that have already been visited.

For every number:
- Calculate the required complement.
- Check if the complement exists in the dictionary.
- If it exists, return the stored index and current index.
- Otherwise, store the current number and index.

## Complexity

Time Complexity: O(n)

Space Complexity: O(n)

## Language

- Python