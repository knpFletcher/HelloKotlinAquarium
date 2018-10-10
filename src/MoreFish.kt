fun fitMoreFish(tankSize: Double, currentFishSizes: List<Int>, newFishSize: Int = 2, hasDecorations: Boolean = true) : Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFishSizes.sum() + newFishSize)
}