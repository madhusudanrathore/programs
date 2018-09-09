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