package com.nero.normal.section01;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 提示:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 * 滑德友：
 * 没啥意思：充满了不确定性，而且看着很简单，而且给的提示足够多了
 */
public class Problem68TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> fullJustifyStringList = new LinkedList<>();

        int totalWidth = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (totalWidth + words[i].length() > maxWidth) {
                String newLine = oneLine(words, start, i - 1, maxWidth);
                fullJustifyStringList.add(newLine);
                start = i;
                totalWidth = 0;
            }
            else {
                totalWidth += words[i].length() + 1;
            }
        }

        if (start >= words.length) {
            return fullJustifyStringList;
        }

        StringBuilder finalLineStringBuilder = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            finalLineStringBuilder.append(words[i]);
            finalLineStringBuilder.append(' ');
        }
        for (int i = totalWidth; i < maxWidth; i++) {
            finalLineStringBuilder.append(' ');
        }

        return fullJustifyStringList;
    }

    private String oneLine(String[] words, int start, int end, int maxWidth) {
        if (end == start) {
            return oneWordOneLine(words, start, maxWidth);
        }
        else {
            return multipleWordOneLine(words, start, end, maxWidth);
        }
    }

    private String multipleWordOneLine(String[] words, int start, int end, int maxWidth) {
        int totalWidth = 0;
        for (int i = start; i <= end; i++) {
            totalWidth += words[i].length();
        }

        int totalBlankGapCount = end - start;
        int totalBlankCount = maxWidth - totalWidth;
        int eachBlankGapCount = totalBlankCount / totalBlankGapCount;
        int remainderBlankCount = totalBlankCount % totalBlankGapCount;
        int firstBlankGapCount = eachBlankGapCount + remainderBlankCount;

        StringBuilder oneLineStringBuilder = new StringBuilder();
        oneLineStringBuilder.append(words[start]);
        for (int i = 0; i < firstBlankGapCount; i++) {
            oneLineStringBuilder.append(' ');
        }

        int i = start + 1;
        while (i < end) {
            oneLineStringBuilder.append(words[i]);
            for (int j = 0; j < firstBlankGapCount; j++) {
                oneLineStringBuilder.append(' ');
            }
        }

        oneLineStringBuilder.append(words[end]);

        return oneLineStringBuilder.toString();
    }

    private String oneWordOneLine(String[] words, int start, int maxWidth) {
        StringBuilder oneLineStringBuilder = new StringBuilder();
        oneLineStringBuilder.append(words[start]);
        for (int i = 0; i < maxWidth - words[start].length(); i++) {
            oneLineStringBuilder.append(' ');
        }
        return oneLineStringBuilder.toString();
    }

}
