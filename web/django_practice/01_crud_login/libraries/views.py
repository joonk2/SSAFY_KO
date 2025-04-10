from django.shortcuts import render, redirect
from .models import Book, Review
from .forms import ReviewForm
from django.contrib.auth.decorators import login_required



# Create your views here.
def index(request):
    books = Book.objects.all()
    context = {
        'books': books
    }
    return render(request, 'libraries/index.html', context)

def detail(request, book_pk):
    book = Book.objects.get(pk=book_pk)
    review_form=ReviewForm()
    reviews=book.review_set.all()
    
    context = {
        'book': book,
        "review_form" : review_form,
        "reviews" : reviews,
    }
    return render(request, 'libraries/detail.html', context)

def create_reviews(request, book_pk):
    book = Book.objects.get(pk=book_pk)
    if request.method == "POST":
        review_form = ReviewForm(request.POST)
        if review_form.is_valid():
            review=review_form.save(commit=False)
            review.user = request.user
            review.book = book
            review.save()
            return redirect("libraries:detail", book.pk)
    else:
        review_form = ReviewForm()
        
    context = {
        "book" : book,
        "review_form" : review_form,
    }
    return render(request, "libraries/detail.html", context)

def delete_reviews(request, book_pk, review_pk):
    book = Book.objects.get(pk=book_pk)
    review = Review.objects.get(pk=review_pk)
    if request.user == review.user:
        if request.method == "POST":
            review.delete()
            
    return redirect("libraries:detail", book.pk)