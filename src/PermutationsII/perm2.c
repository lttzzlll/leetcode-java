# include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void printArr(int num[], int len) {
    for (int i = 0; i < len; i++) {
        printf("%2d\t", num[i]);
    }
    printf("\n");
}

void perm(int num[], int start, int len) {
    if (start == len - 1) {
        //printArr(num, len);
        return;
    }
    for (int i = start; i < len; i++) {
        if (i > start && num[i] == num[start]) continue;
        swap(&num[i], &num[start]);
        //printArr(num, len);
        printf("start=%d, i=%d\n", start, i);
        //getchar();
        perm(num, start + 1, len);
    }
}
/**
 * 1 1 2 2
 * ^
 *   ^
 *     ^
 * 2 1 1 2
 *
 */
void bubble_sort(int num[], int len) {
    int flag = 1;
    int pos = 0;
    while (flag) {
        flag = 0;
        pos++;
        for (int i = 0; i < len - pos; i++) {
            if (num[i] > num[i+1]) {
                swap(&num[i], &num[i + 1]);
                flag = 1;
            }
        }
    }
}

int main() {
    int num[] = {1 ,2, 1, 2};
    int len = sizeof(num) / sizeof(int);
    bubble_sort(num, len);
    printArr(num, len);
    printf("-----------------\n");
    perm(num, 0, len); 
    return 0;
}
