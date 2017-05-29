class Q268 {
    func missingNumber(_ nums: [Int]) -> Int {
        if nums == nil || nums.isEmpty{
            return -1
        }
        var x:Int = nums[0]
        let n:Int = nums.count
        for i in 1..<n{
            x ^= nums[i]
        }
        var y:Int = 0
        for i in 0...n{
            y ^= i
        }
        return x ^ y
    }
}
