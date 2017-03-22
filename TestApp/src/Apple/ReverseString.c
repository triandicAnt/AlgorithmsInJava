

void reverse_string(char *str){
  if (str == 0)
    {
        return;
    }

    /* skip empty string */
    if (*str == 0)
    {
        return;
    }

    /* get range */
    char *start = str;
    char *end = start + strlen(str) - 1; /* -1 for \0 */
    char temp;

    /* reverse */
    while (end > start)
    {
      *start = *start ^ *end;
      *end = *start ^ *end;
      *start = *start ^ *end;
        /* swap */
        // temp = *start;
        // *start = *end;
        // *end = temp;

        /* move */
        ++start;
        --end;
    }
}

int reverseBit(int x){
  int b= 0;
  while (x!=0){
    b<<=1;
    b|=( x &1);
    x>>=1;
  }
}
uint32_t littleToBigEndian(uint32_t num){
  uint32_t res = 0;
  b0 = (num & 0xff) << 24;       // ; least significant to most significant
  b1 = (num & 0xff00) << 8;      // ; 2nd least sig. to 2nd most sig.
  b2 = (num & 0xff0000) >> 8;     //; 2nd most sig. to 2nd least sig.
  b3 = (num & 0xff000000) >> 24; // ; most sig. to least sig.
  res = b0 | b1 | b2 | b3 ;
  return res;
}

int main()
{
 char s1[] = "Reverse me!";
    char s2[] = "abc";
    char s3[] = "ab";
    char s4[] = "a";
    char s5[] = "";

    reverse_string(0);

    reverse_string(s1);
    reverse_string(s2);
    reverse_string(s3);
    reverse_string(s4);
    reverse_string(s5);

    printf("%s\n", s1);
    printf("%s\n", s2);
    printf("%s\n", s3);
    printf("%s\n", s4);
    printf("%s\n", s5);

    return 0;
}
