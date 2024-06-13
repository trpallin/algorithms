class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) return emptyList()

        nums.sort()

        var res = mutableListOf<List<Int>>()

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] == nums[i-1]) continue
            for (j in i+1 until nums.size) {
                if (j > i+1 && nums[j] == nums[j-1]) continue
                var left = j + 1
                var right = nums.size-1
                val t = target.toLong() - nums[i].toLong() - nums[j].toLong()
                while (left < right) {
                    if (nums[left].toLong() + nums[right].toLong() == t) {
                        res.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left+1]) left++
                        while (left < right && nums[right] == nums[right-1]) right--
                        left++
                        right--
                    } else if (nums[left].toLong() + nums[right].toLong() > t) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res
    }
}