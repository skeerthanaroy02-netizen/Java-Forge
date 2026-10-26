# JavaForge

**JavaForge** is a small, beginner-friendly Java library of reusable utilities, algorithms, and data structures. It is designed for learning and meaningful open-source contributions.

## Requirements

- JDK 17 or later
- Maven 3.8+

## Quick Start

Clone the repository:

```bash
git clone https://github.com/YOUR-USERNAME/Java-Forge.git
cd Java-Forge/JavaForge
mvn test
```

Replace `YOUR-USERNAME` with your GitHub username.

> Note: These commands assume the Maven project remains inside the `JavaForge` subfolder.

## Current Utilities

- `StringUtils.isPalindrome(String)` — checks a string while ignoring letter case and non-alphanumeric characters.
- `StringUtils.reverse(String)` — reverses a string by Unicode code points.
- `NumberUtils.isPrime(int)` — checks whether an integer is prime.
- `NumberUtils.getFibonacci(int)` — returns the n-th Fibonacci number as a BigInteger, or throws an IllegalArgumentException if n is negative.
- `ArrayUtils.binarySearch(int[], int)` — searches a sorted array and returns the matching index or `-1`.

## Contributing

Contributions are welcome! Please check the repository's Issues tab, read [CONTRIBUTING.md](CONTRIBUTING.md), and submit a pull request.

Discuss an issue before beginning substantial work.

## Project Status

This is an early-stage community project. APIs may evolve as the project grows.

## License

Distributed under the MIT License. See [LICENSE](LICENSE) for details.
