class Node{
    int data=0;
    Node left=null, right=null;

    Node(int value){
        this.data=value;
    }
}

public class BinarySearchTree{
    private head, temp, pre_temp;
    BinarySearchTree(){
        head=null;
    }
}

class bst {
    public:

        void insert_node(){//INSERTING RANDOM DATA
            node *new_node = new node;
            new_node->left = NULL;
            new_node->right = NULL;

            if ( head == NULL ) {//EMPTY TREE
                new_node->data = 10;//ROOT = 10
                head = new_node;
                cout << "BST Created" << endl;
            }
            else{//NON-EMPTY TREE
                int val;
                val = new_node->data = rand() % 3567;
                temp = head;

                while ( temp ) {
                    pre_temp = temp;
                    if ( temp->data >= val )
                        temp = temp->left;
                    else
                        temp = temp->right;
                }

                if ( pre_temp->data >= val )
                    pre_temp->left = new_node;
                else
                    pre_temp->right = new_node;
                cout << val << " NODE INSERTED" << endl;
            }
        }

        void preorder(node *temp2) {//PARENT LEFT RIGHT
            if ( temp2!=NULL ) {
                cout << temp2->data << " ";
                preorder(temp2->left);
                preorder(temp2->right);
            }
        }

        void inorder(node *temp2) {//LEFT PARENT RIGHT
            if (temp2 != NULL) {
                preorder(temp2->left);
                cout << temp2->data << " ";
                preorder(temp2->right);
            }
        }

        void postorder(node *temp2) {//LEFT RIGHT PARENT
            if (temp2 != NULL) {
                preorder(temp2->left);
                preorder(temp2->right);
                cout << temp2->data << " ";
            }
        }

        void search_node() {
            if ( head == NULL )
                cout << "BST EMPTY" << endl;

            else {
                int val;
                cout << "Enter Value to be SEARCHED\t";
                cin >> val;
                temp = head;

                while (temp!=NULL && temp->data != val) {
                    if (temp->data > val)
                        temp = temp->left;
                    else
                        temp = temp->right;
                }

                ( temp ) ? cout << val << " FOUND" << endl : cout << val << " NOT FOUND" << endl;
            }
        }

        int height( node *temp2 ){
            int lh, rh;

            if( temp2 == NULL )
                return 0;
            else{
                lh = height( temp2->left );
                rh = height( temp2->right );

                if(lh > rh)
                    return 1 + lh;
                else
                    return 1 + rh;
            }
        }

        void smallest(){
            temp = head;
            while( temp->left )
                temp = temp->left;

            cout << "SMALLEST IS " << temp->data << endl;
        }

        void largest() {
            temp = head;
            while( temp->right )
                temp = temp->right;

            cout << "LARGEST IS " << temp->data << endl;
        }

        int totalNodes( node *temp2 ){
            if( !temp2 )
                return 0;
            else
                return totalNodes( temp2->left ) + totalNodes( temp2->right ) + 1;
        }

        int totalExternalNodes( node *temp2 ){
            if( !temp2 )
                return 0;
            if( temp2->left == NULL && temp2->right == NULL )
                return 1;
            else
                return totalNodes( temp2->left ) + totalNodes( temp2->right );
        }

        node* returnLargest( node *temp2 ) {
            if( ( temp2 == NULL ) || ( temp2->right == NULL ) )
                return temp2;
            else
                return returnLargest( temp2->right );
        }

        node* deleteNode( node *tree, int val ){
            node *new_temp;
            if( tree == NULL )//VALUE NOT FOUND
                cout << val << " NOT FOUND" << endl;
            else if( tree->data > val )
                tree->left = deleteNode( tree->left, val);
            else if( tree->data < val )
                tree->right = deleteNode( tree->right, val);
            else{//VAL FOUND
                if( tree->left && tree->right ){//NODE WITH TWO CHILDREN
                    new_temp = returnLargest( tree->left );//INORDER PREDECESSOR, LARGEST IN LEFT-SUBTREE
                    tree->data = new_temp->data;
                    tree->left = deleteNode( tree->left, new_temp->data );
                }else{
                    new_temp = tree;
                    if( tree->left == NULL && tree->right == NULL )//LEAF NODE
                        tree = NULL;
                    else if( tree->left != NULL )
                        tree = tree->left;
                    else
                        tree = tree->right;
                    delete new_temp;
                }
            }
            return tree;
        }

        int totalInternalNodes(){
            return totalNodes( this->head ) - totalExternalNodes( this->head );
        }

        void deleteTree( node *temp2 ){
            if( temp2 ){
                deleteTree( temp2->left );
                deleteTree( temp2->right );
                delete temp2;
            }
        }

};

int main() {

	bst tree;
	short choice;
	bool repeat = true;
	int val;
	for (int k = 0; k < 10; k++)
		tree.insert_node();

	while( repeat ){
        cout << endl;
        cout << "1). EXIT" << endl;
        cout << "2). INSERT" << endl;
        cout << "3). PREORDER TRAVERSAL" << endl;
        cout << "4). INORDER TRAVERSAL" << endl;
        cout << "5). POSTORDER TRAVERSAL" << endl;
        cout << "6). SEARCH" << endl;
        cout << "7). HEIGHT" << endl;
        cout << "8). SMALLEST" << endl;
        cout << "9). LARGEST" << endl;
        cout << "10). TOTAL NODES" << endl;
        cout << "11). TOTAL EXTERNAL NODES" << endl;
        cout << "12). TOTAL INTERNAL NODES" << endl;
        cout << "13). DELETE SPECIFIC NODE" << endl;
        cout << "14). DELETE TREE" << endl;
        cin >> choice;

        switch (choice) {
            case 1:
                repeat = false;
                break;
            case 2:
                tree.insert_node();
                break;
            case 3:
                tree.preorder( tree.head );
                break;
            case 4:
                tree.inorder( tree.head );
                break;
            case 5:
                tree.postorder( tree.head );
                break;
            case 6:
                tree.search_node();
                break;
            case 7:
                val = tree.height( tree.head );
                cout << "HEIGHT OF BST IS " << val << endl;
                break;
            case 8:
                tree.smallest();
                break;
            case 9:
                tree.largest();
                break;
            case 10:
                cout << "TOTAL NODES = " << tree.totalNodes( tree.head ) << endl;
                break;
            case 11:
                cout << "TOTAL EXTERNAL NODES = " << tree.totalExternalNodes( tree.head ) << endl;
                break;
            case 12:
                cout << "TOTAL INTERNAL NODES = " << tree.totalInternalNodes() << endl;
                break;
            case 13:
                cout << "ENTER VALUE TO BE DELETED\t";
                cin >> val;
                temp = tree.deleteNode( tree.head, val );
                break;
            case 14:
                tree.deleteTree( tree.head );
                tree.head = NULL;
                break;
            default:
                cout << "INVALID OPTION" << endl;
                break;
        }
    }

	return 0;
}