
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "passwords.h"
#include "sha256.h"

#define DIG_BIN_LEN 32
#define DIG_STR_LEN ((DIG_BIN_LEN * 2) + 1)
#define MAX_PASSWORD 64

void sha256(char *dest, char *src) {
    // zero out the sha256 context
    struct sha256_ctx ctx;
    memset(&ctx, 0, sizeof(ctx));

    // zero out the binary version of the hash digest
    unsigned char dig_bin[DIG_BIN_LEN];
    memset(dig_bin, 0, DIG_BIN_LEN);

    // zero out the string version of the hash digest
    memset(dest, 0, DIG_STR_LEN);

    // compute the binary hash digest
    __sha256_init_ctx(&ctx);
    __sha256_process_bytes(src, strlen(src), &ctx);
    __sha256_finish_ctx(&ctx, dig_bin);

    // convert it into a string of hexadecimal digits
    for (int i = 0; i < DIG_BIN_LEN; i++) {
        snprintf(dest, 3, "%02x", dig_bin[i]);
        dest += 2;
    }
}

//clear text --> leet text
char* leetify(char* scpy, char* teststr){
	strcpy(scpy, teststr);
	int len = strlen(scpy);
	for(int i =  0; i < len; i++){
		switch (teststr[i]){
			case 'o':
				scpy[i] = '0';
				break;
			case 'e':
				scpy[i] = '3';
				break;
			case 'i':
				scpy[i] = '!';
				break;
			case 'a':
				scpy[i] = '@';
				break;
			case 'h':
				scpy[i] = '#';
				break;
			case 's':
				scpy[i] = '$';
				break;
			case 't':
				scpy[i] = '+';
				break;
			default:
				scpy[i] = teststr[i];
		}
	}
	return scpy;
}
	
//clear text into plus one text
char* addone(char* s, char* teststr){
   //str concat to add +1
   	strcpy(s, teststr);
   	strcat(s, "1");
   	char addone[DIG_STR_LEN];
	return s;
}
		  

int main(int argc, char *argv[]){
	char hash[DIG_STR_LEN];	
//64 + 1 to create space for the null
	char str[65]; 
	
 //loop iterating through the 10,000 passwords
	
	for(int i = 0; i < 10000;  i++){	
//converting into a hash and comapring w/ given hash
		sha256(hash, passwords[i]);	
		if(strcmp(argv[1], hash) == 0){
		
//if the two hashes match, the original with be printed and move to the next password in the list
			printf("%s\n", passwords[i]);
			return 0;			
		} 		
			sha256(hash, leetify(str, passwords[i]));
		 if (strcmp(argv[1], hash) == 0) {
			printf("%s\n", str);
			return 0;				
		} 
			sha256(hash, addone(str, passwords[i]));
		 if (strcmp(argv[1], hash) == 0){
			printf("%s\n", str);
			return 0;

		} 		
//if the hash does not match any of the given hashes, 'not found' will be printed			
		}		
	printf("%s\n", "not found");
	return 0;

}