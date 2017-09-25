/*
*	Matthew Ruiz
*	CSC331-80 
*	Assignment1
*/
#include <sys/types.h>

#include <stdio.h>

#include <unistd.h>

#include <stdlib.h>

#include <sys/wait.h>


int main(){

	pid_t pid;

	/*fork a child process	*/
	pid = fork();

	int n, first = 0, second = 1, next, c;
	if(pid < 0){ /* error occurred*/
	        fprintf(stderr, "Fork Failed");

		exit(-1);

	}

	else if(pid == 0){ /* child process */
		printf("Enter the number of terms\n"); /* Prompt the user to enter the amount of*/
		scanf("%d", &n);			/*Fibonacci digits they want to see */
		
 if(n < 1){
			while(n<1){/*Will continue to prompt the user if they enter a number less than 1*/
			printf("%d is invalid. Please provide a positive number!\n",n);

			scanf("%d", &n);
			}
		}
		else
			printf("First %d terms of the Fibonacci series are: -\n", n);

		
	for(c=0;c<n;c++){/*Prints out the numbers of the Fibonacci sequence*/
				if(c<=1)

					next = c;

				else{

					next = first + second;

					first = second;

					second = next;

				}

				printf("%d ", next);
			}

			return 0;


	}

	else{
		wait(NULL);/*parent will wait for the child process to complete*/
		
printf("\nChild Complete\n");

		exit(0);

	}


}