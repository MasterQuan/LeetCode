package com.quan.graph;

/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。
 * 需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) return image;
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    private void dfs(int[][] image, int row, int col, int color, int newColor){
        if (row < 0 || row >= image.length || col < 0 || col >=  image[row].length || image[row][col] != color)
            return;
        image[row][col] = newColor;
        dfs(image, row - 1, col, color, newColor);
        dfs(image, row + 1, col, color, newColor);
        dfs(image, row, col - 1, color, newColor);
        dfs(image, row, col + 1, color, newColor);
    }
}
