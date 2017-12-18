# include<stdio.h>

void swap(int *a, int *b) {
    if (*a != *b) {
        int temp = *a;
        *a = *b;
        *b = temp;
    }
}

void printArr(int num[], int len) {
    for (int i = 0; i < len; i++) {
        printf("%2d\t", num[i]);
    }
    printf("\n");
}

void perm(int num[], int start, int len) {
    if (start == len - 1) {
        printArr(num, len);
        return;
    }
    for (int i = start; i < len; i++) {
        swap(&num[i], &num[start]);
        perm(num, start + 1, len);
        swap(&num[i], &num[start]);
    }
}

int main() {
    int num[] = {1, 2, 3};
    perm(num, 0, sizeof(num) / sizeof(int));
    return 0;
}
