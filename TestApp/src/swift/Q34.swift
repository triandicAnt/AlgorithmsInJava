class Q34 {
    func searchRange(_ nums: [Int], _ target: Int) -> [Int] {
        var res :[Int] = [-1,-1]
        if nums == nil || nums.isEmpty{
            return res
        }
        var i :Int = 0
        var j :Int = nums.count-1
        while i<j{
            let mid:Int = (i+j)/2
            if nums[mid]<target{
                i = mid+1
            }else{
                j = mid
            }
        }
        if nums[i] != target{
            return res
        }
        res[0] = i
        j = nums.count-1
        while i<j{
            let mid = (i+j)/2 + 1
            if nums[mid]>target{
                j = mid-1
            }
            else{
                i = mid
            }
        }
        if nums[i] != target{
            res[1] = res[0]
        }
        else{
            res[1] = i
        }
        return res
    }
}
