git filter-branch --env-filter '
 
an="$GIT_AUTHOR_NAME"
am="$GIT_AUTHOR_EMAIL"
cn="$GIT_COMMITTER_NAME"
cm="$GIT_COMMITTER_EMAIL"
 
if [ "$GIT_COMMITTER_EMAIL" = "rodrigokuninari@gmail.com" ]
then
    cn="RodrigoKuninari"
    cm="rkn1312@hotmail.com"
fi
if [ "$GIT_AUTHOR_EMAIL" = "rodrigokuninari@gmail.com" ]
then
    an="RodrigoKuninari"
    am="rkn1312@hotmail.com"
fi
 
export GIT_AUTHOR_NAME="$an"
export GIT_AUTHOR_EMAIL="$am"
export GIT_COMMITTER_NAME="$cn"
export GIT_COMMITTER_EMAIL="$cm"
'