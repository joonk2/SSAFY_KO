from django.urls import path
from . import views


app_name = 'libraries'

urlpatterns = [
    path('', views.index, name='index'),
    path('<int:book_pk>/', views.detail, name='detail'),
    path('<int:book_pk>/create_reviews/', views.create_reviews, name = 'create_reviews'),
    path('<int:book_pk>/delete_reviews/<int:review_pk>/', views.delete_reviews, name = "delete_reviews"),
]
