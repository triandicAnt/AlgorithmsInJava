class Q231 {
    func isPowerOfTwo(_ n: Int) -> Bool {
        if n <= 0{
            return false
        }
        return n & (n-1) == 0
    }
}
