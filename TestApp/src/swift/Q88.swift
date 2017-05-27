class Q88 {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        if nums1 == nil || nums2 == nil{
            return
        }
        var i:Int = m-1
        var j:Int = n-1
        var k:Int = m+n-1
        while i >= 0 && j >= 0{
            if nums1[i] > nums2[j]{
                nums1[k] = nums1[i]
                i = i-1
            }else{
                nums1[k] = nums2[j]
                j = j-1
            }
            k = k-1
        }
        while i>=0{
            nums1[k] = nums1[i]
            i = i-1
            k = k-1
        }
        while j>=0{
            nums1[k] = nums2[j]
            j = j-1
            k = k-1
        }
    }
}
