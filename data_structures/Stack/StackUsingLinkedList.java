#include <stdio.h>
#include <stdbool.h>

struct stack{
    int data;
    struct stack *next;
};

struct stack *top = NULL;
struct stack *temp = NULL;

int value;

int count = 0;

void push( void ){

    struct stack *element;
    element = new stack;
    ++count;

    printf("ENTER VALUE\t");
    scanf("%d", &value);
    element->data = value;
    printf("%d INSERTED\n", value);

    if( top == NULL ){
        top = element;
        top->next = NULL;
    }
    else{
        element->next = top;
        top = element;
    }

}

void pop( void ){

    if( top == NULL ){
        printf("UNDERFLOW\n");
    }
    else{
        temp = top;
        top = top->next;

        printf("%d DELETED\n", temp->data);
        delete temp;
        --count;
    }
}

void display( void ){

    if( top == NULL){
        printf("EMPTY STACK\n");
    }
    else{
        temp = top;
        int i = count;
        while( temp != NULL ){
            printf("stack[%d] = %d\n", i, temp->data);

            temp = temp->next;
            --i;
        }
    }

}

int main(){

    int choice;
    bool again = true;

	while( again ){

        printf("1). PUSH\n");
        printf("2). POP\n");
        printf("3). DISPLAY\n");
        printf("4). EXIT\n");
        printf("ENTER CHOICE\t");

		scanf("%d", &choice);

		switch( choice ){
			case 1:
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				display();
				break;
			case 4:
				again = false;
				break;
			default:
				printf("ERROR CHOICE\n");
		}
	}
    return 0;
}
